export default function Topbar() {
    return (
        <header className="bg-white shadow">
            <div className="container mx-auto px-4">
                <div className="flex items-center justify-between h-16">
                    <div className="flex items-center">
                        <a href="/" className="text-xl font-bold text-gray-800">
                            Blog App
                        </a>
                    </div>
                    <div className="flex items-center">
                        <input type="text" placeholder="Search..." className="px-3 py-2 border rounded-md text-sm" />
                        <button className="ml-4 px-4 py-2 bg-blue-500 text-white rounded-md text-sm">Sign In</button>
                    </div>
                </div>
            </div>
        </header>
    )
}