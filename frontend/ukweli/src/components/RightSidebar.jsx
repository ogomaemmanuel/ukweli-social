export default function RightSidebar() {
    const trendingTopics = ["React", "Tailwind CSS", "Next.js", "TypeScript", "Web Development"]
    const whoToFollow = [
        { id: 1, name: "John Doe", username: "@johndoe" },
        { id: 2, name: "Jane Smith", username: "@janesmith" },
        { id: 3, name: "Bob Johnson", username: "@bobjohnson" },
    ]

    return (
        <aside className="w-full lg:w-1/4">
            <div className="bg-white rounded-lg shadow p-6 mb-8">
                <h2 className="text-xl font-bold mb-4">Trending Topics</h2>
                <ul className="space-y-2">
                    {trendingTopics.map((topic, index) => (
                        <li key={index}>
                            <a href="#" className="text-blue-500 hover:underline">
                                #{topic}
                            </a>
                        </li>
                    ))}
                </ul>
            </div>
            <div className="bg-white rounded-lg shadow p-6">
                <h2 className="text-xl font-bold mb-4">Who to Follow</h2>
                <ul className="space-y-4">
                    {whoToFollow.map((user) => (
                        <li key={user.id} className="flex items-center justify-between">
                            <div>
                                <p className="font-semibold">{user.name}</p>
                                <p className="text-gray-500 text-sm">{user.username}</p>
                            </div>
                            <button className="px-4 py-2 bg-blue-500 text-white rounded-full text-sm">Follow</button>
                        </li>
                    ))}
                </ul>
            </div>
        </aside>
    )
}